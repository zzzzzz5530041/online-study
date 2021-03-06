package com.online.edu.web.entity.website;

import java.io.Serializable;

/**
 * 广告图片类型
 * @author
 */
public class WebSiteImagesType implements Serializable{
	private static final long serialVersionUID = -5345545736423067440L;
	/**类型ID*/
	private int typeId;
	/**类型名*/
	private String typeName;

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
}
