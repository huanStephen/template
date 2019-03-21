package com.eocencle.template.service;

import com.eocencle.template.entity.DemoEntity;

import java.util.List;

/**
 * @Auther: shizh26250
 * @Date: 2018/12/2 14:39
 * @Description:
 */
public interface IDemoService {

    DemoEntity getDemo(Integer id);

    List<DemoEntity> getDemo(String zfljxx);

    List<DemoEntity> getDemoByLike(String title);

    void updateDemo() throws Exception;

}
