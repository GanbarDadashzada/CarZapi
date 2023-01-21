package com.carzapi.digital.service.specification;

import com.carzapi.digital.dao.entity.AnnouncementEntity;
import com.carzapi.digital.model.dto.AnnouncementCriteria;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class AnnouncementSpecification implements Specification<AnnouncementEntity> {

    private AnnouncementCriteria criteria;

    @Override
    public Predicate toPredicate(Root<AnnouncementEntity> r, CriteriaQuery<?> q, CriteriaBuilder cb) {
        List<Predicate> predicates = new ArrayList<>();

        if(criteria.getBrandId() != null) {
            predicates.add(cb.equal(r.get("modelEntity").get("brandEntity").get("id"), (criteria.getBrandId())));
        }

        if(criteria.getModelId() != null) {
            predicates.add(cb.equal(r.get("modelEntity").get("id"), criteria.getModelId()));
        }

        if(criteria.getCityId() != null) {
            predicates.add(cb.equal(r.get("cityEntity").get("id"), criteria.getCityId()));
        }

        if(criteria.getPrice() != null) {
            predicates.add(cb.equal(r.get("price"), criteria.getPrice()));
        }

        if(criteria.getColourId() != null) {
            predicates.add(cb.equal(r.get("colourId").get("id"), criteria.getColourId()));
        }

        if(criteria.getFuel() != null) {
            predicates.add(cb.equal(r.get("fuel"), criteria.getFuel()));
        }

        if(criteria.getGearBox() != null) {
            predicates.add(cb.equal(r.get("gearBox"), criteria.getGearBox()));
        }

        if(criteria.getConductorType() != null) {
            predicates.add(cb.equal(r.get("conductorType"), criteria.getConductorType()));
        }

        if(criteria.getMotorSize() != null) {
            predicates.add(cb.equal(r.get("motorSize"), criteria.getMotorSize()));
        }

        if(criteria.getMotorPower() != null) {
            predicates.add(cb.equal(r.get("motorPower"), criteria.getMotorPower()));
        }

        if(criteria.getDistanceType() != null) {
            predicates.add(cb.equal(r.get("distanceType"), criteria.getDistanceType()));
        }

        if(criteria.getDistanceUnit() != null) {
            predicates.add(cb.equal(r.get("distanceUnit"), criteria.getDistanceUnit()));
        }

        if(criteria.getOwnership() != null) {
            predicates.add(cb.equal(r.get("ownership"), criteria.getOwnership()));
        }

        if(criteria.getSeatCount() != null) {
            predicates.add(cb.equal(r.get("seatCount"), criteria.getSeatCount()));
        }

        if(criteria.getConditionIds() != null) {
            predicates.add(cb.isTrue(r.get("conditionEntities")).in(criteria.getConditionIds()));
        }

        if(criteria.getEquipmentIds() != null) {
            predicates.add(cb.isTrue(r.get("equipmentIds")).in(criteria.getEquipmentIds()));
        }

        return cb.and(predicates.toArray(new Predicate[0]));
        //TODO: check it out while testing the specification
    }
}

