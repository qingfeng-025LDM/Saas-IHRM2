package com.ihrm.common.service;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class BaseService<T> {

    protected Specification getSpecification(String companyId){
        Specification<T> specification = new Specification<T>() {
            /**
             * 用户构造查询条件
             * @param root：包含了所有的对象数据
             * @param criteriaQuery：一般不用
             * @param criteriaBuilder：构造查询条件
             * @return
             */
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get("companyId").as(String.class), companyId);
            }
        };
        return specification;
    }
}
