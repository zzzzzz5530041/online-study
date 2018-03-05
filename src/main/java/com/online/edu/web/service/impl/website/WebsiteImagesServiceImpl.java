package com.online.edu.web.service.impl.website;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.online.edu.common.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.edu.common.constants.CacheConstans;
import com.online.edu.common.entity.PageEntity;
import com.online.edu.web.dao.website.WebsiteImagesDao;
import com.online.edu.web.entity.website.WebsiteImages;
import com.online.edu.web.service.website.WebsiteImagesService;

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

                List<WebsiteImages> wiList = new ArrayList<WebsiteImages>();
                int typeId = imageList.get(0).getTypeId();
                for (WebsiteImages websiteImage : imageList) {
                    if (typeId == websiteImage.getTypeId()) {
                        wiList.add(websiteImage);
                    } else {
                        imageMapList.put("type_" + typeId, wiList);
                        wiList = new ArrayList<WebsiteImages>();
                        wiList.add(websiteImage);
                    }
                    typeId = websiteImage.getTypeId();
                }
                //添加最后一条记录

                imageMapList.put("type_" + typeId, wiList);
//                EHCacheUtil.set(CacheConstans.BANNER_IMAGES, imageMapList, CacheConstans.BANNER_IMAGES_TIME);
                redisUtils.save(CacheConstans.BANNER_IMAGES,imageMapList);
            }
        }
        return imageMapList;
    }


}
