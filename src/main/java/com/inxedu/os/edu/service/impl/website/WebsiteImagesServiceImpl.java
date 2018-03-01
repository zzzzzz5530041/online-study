package com.inxedu.os.edu.service.impl.website;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.inxedu.os.common.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inxedu.os.common.constants.CacheConstans;
import com.inxedu.os.common.entity.PageEntity;
import com.inxedu.os.edu.dao.website.WebsiteImagesDao;
import com.inxedu.os.edu.entity.website.WebsiteImages;
import com.inxedu.os.edu.service.website.WebsiteImagesService;

/**
 * 广告图service 实现
 *
 * @author www.inxedu.com
 */
@Service("websiteImagesService")
public class WebsiteImagesServiceImpl implements WebsiteImagesService {
    @Autowired
    private WebsiteImagesDao websiteImagesDao;
    @Autowired
    private RedisUtils redisUtils;

    @Override
    public int creasteImage(WebsiteImages image) {
        redisUtils.remove(CacheConstans.BANNER_IMAGES);
        return websiteImagesDao.creasteImage(image);
    }

    @Override
    public List<Map<String, Object>> queryImagePage(WebsiteImages image,
                                                    PageEntity page) {
        return websiteImagesDao.queryImagePage(image, page);
    }

    @Override
    public WebsiteImages queryImageById(int imageId) {
        return websiteImagesDao.queryImageById(imageId);
    }

    @Override
    public void deleteImages(String imageIds) {
        websiteImagesDao.deleteImages(imageIds);
        redisUtils.remove(CacheConstans.BANNER_IMAGES);
    }

    @Override
    public void updateImage(WebsiteImages image) {
        websiteImagesDao.updateImage(image);
        redisUtils.remove(CacheConstans.BANNER_IMAGES);
    }

    @Override
    public Map<String, List<WebsiteImages>> queryImagesByType() {
        //从缓存中查询图片数据
        @SuppressWarnings("unchecked")
//		Map<String,List<WebsiteImages>> imageMapList = (Map<String,List<WebsiteImages>>) EHCacheUtil.get(CacheConstans.BANNER_IMAGES);
        Map<String, List<WebsiteImages>> imageMapList = redisUtils.getByKey(CacheConstans.BANNER_IMAGES, Map.class);
        //如果缓存中不存在则重新查询
        if (imageMapList == null) {
            List<WebsiteImages> imageList = websiteImagesDao.queryImagesByType();
            if (imageList != null && imageList.size() > 0) {
                imageMapList = new HashMap<String, List<WebsiteImages>>();

                List<WebsiteImages> _list = new ArrayList<WebsiteImages>();
                int typeId = imageList.get(0).getTypeId();
                for (WebsiteImages _wi : imageList) {
                    if (typeId == _wi.getTypeId()) {
                        _list.add(_wi);
                    } else {
                        imageMapList.put("type_" + typeId, _list);
                        _list = new ArrayList<WebsiteImages>();
                        _list.add(_wi);
                    }
                    typeId = _wi.getTypeId();
                }
                //添加最后一条记录

                imageMapList.put("type_" + typeId, _list);
//                EHCacheUtil.set(CacheConstans.BANNER_IMAGES, imageMapList, CacheConstans.BANNER_IMAGES_TIME);
                redisUtils.save(CacheConstans.BANNER_IMAGES,imageMapList);
            }
        }
        return imageMapList;
    }


}
