package com.online.edu.common.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.Assert;

public class GsonHttpMessageConverter extends AbstractHttpMessageConverter<Object> {
    public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");
    private Gson gson;
    private Type type;
    private boolean prefixJson;

    public GsonHttpMessageConverter() {
        this((new GsonBuilder()).setDateFormat("yyyy-MM-dd HH:mm:ss").create());
    }

    public GsonHttpMessageConverter(boolean serializeNulls) {
        this(serializeNulls ? (new GsonBuilder()).serializeNulls().create() : new Gson());
    }

    public GsonHttpMessageConverter(Gson gson) {
        super(new MediaType("application", "json", DEFAULT_CHARSET));
        this.type = null;
        this.prefixJson = false;
        this.setGson(gson);
    }

    public void setGson(Gson gson) {
        Assert.notNull(gson, "'gson' must not be null");
        this.gson = gson;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Type getType() {
        return this.type;
    }

    public void setPrefixJson(boolean prefixJson) {
        this.prefixJson = prefixJson;
    }

    public boolean canRead(Class<?> clazz, MediaType mediaType) {
        return this.canRead(mediaType);
    }

    public boolean canWrite(Class<?> clazz, MediaType mediaType) {
        return this.canWrite(mediaType);
    }

    protected boolean supports(Class<?> clazz) {
        throw new UnsupportedOperationException();
    }

    protected Object readInternal(Class<?> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        InputStreamReader json = new InputStreamReader(inputMessage.getBody(), this.getCharset(inputMessage.getHeaders()));

        try {
            Type ex = this.getType();
            return ex != null ? this.gson.fromJson(json, ex) : this.gson.fromJson(json, clazz);
        } catch (JsonSyntaxException var5) {
            throw new HttpMessageNotReadableException("Could not read JSON: " + var5.getMessage(), var5);
        } catch (JsonIOException var6) {
            throw new HttpMessageNotReadableException("Could not read JSON: " + var6.getMessage(), var6);
        } catch (JsonParseException var7) {
            throw new HttpMessageNotReadableException("Could not read JSON: " + var7.getMessage(), var7);
        }
    }

    protected void writeInternal(Object o, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        OutputStreamWriter writer = new OutputStreamWriter(outputMessage.getBody(), this.getCharset(outputMessage.getHeaders()));

        try {
            if (this.prefixJson) {
                writer.append("{} && ");
            }

            Type ex = this.getType();
            if (ex != null) {
                this.gson.toJson(o, ex, writer);
            } else {
                this.gson.toJson(o, writer);
            }

            writer.close();
        } catch (JsonIOException var5) {
            throw new HttpMessageNotWritableException("Could not write JSON: " + var5.getMessage(), var5);
        }
    }

    private Charset getCharset(HttpHeaders headers) {
        return headers != null && headers.getContentType() != null && headers.getContentType().getCharSet() != null ? headers.getContentType().getCharSet() : DEFAULT_CHARSET;
    }
}