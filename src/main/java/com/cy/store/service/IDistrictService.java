package com.cy.store.service;

import com.cy.store.entity.District;

import java.util.List;

public interface IDistrictService {

    /**
     * 根据父代码号来查询区域信息(省或市或区)
     * @param parent 父代码号
     * @return 多个区域的信息
     */
    List<District> getByParent(String parent);

    String getNameByCode(String code);
}
