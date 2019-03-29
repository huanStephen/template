package org.eocencle.template.service.impl;

import org.eocencle.template.dao.DemoMapper;
import org.eocencle.template.entity.DemoEntity;
import org.eocencle.template.service.IDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Auther: shizh26250
 * @Date: 2018/12/2 14:45
 * @Description:
 */
@Service
public class DemoServiceImpl implements IDemoService {

    @Autowired
    @SuppressWarnings("SpringJavaAutowiringInspection")
    private DemoMapper demoMapper;

    /**
     * 主键查询
     * 功能描述:
     *
     * @param:
     * @return:
     * @auther:
     * @date: 2018/12/2 14:51
     */
    @Override
    public DemoEntity getDemo(Integer id) {
        return this.demoMapper.selectByPrimaryKey(id);
    }

    /**
     * 数值匹配查询
     * 功能描述:
     *
     * @param:
     * @return:
     * @auther:
     * @date: 2018/12/2 14:52
     */
    @Override
    public List<DemoEntity> getDemo(String zfljxx) {
        DemoEntity record = new DemoEntity();
        record.setSfljxx(zfljxx);

        return this.demoMapper.select(record);
    }

    /**
     * 模糊查询
     * 功能描述:
     *
     * @param:
     * @return:
     * @auther:
     * @date: 2018/12/2 14:54
     */
    @Override
    public List<DemoEntity> getDemoByLike(String title) {
        Example example = new Example(DemoEntity.class);
        example.createCriteria().andLike("title", "%" + title + "%");

        return this.demoMapper.selectByExample(example);
    }

    /**
     * 事务测试
     * 功能描述: 
     *
     * @param:
     * @return: 
     * @auther: 
     * @date: 2018/12/4 17:16
     */
    @Override
    @Transactional
    public void updateDemo() throws Exception {
        DemoEntity record = new DemoEntity();
        record.setId(1);
        record.setZddz("北京市");

        this.demoMapper.updateByPrimaryKeySelective(record);

        throw new Exception("异常");
    }

}
