package com.carzapi.digital.service.specification;

import com.carzapi.digital.dao.entity.AnnouncementEntity;
import com.carzapi.digital.dao.entity.AnnouncementPrivilegeEntity;
import com.carzapi.digital.dao.entity.ConditionEntity;
import com.carzapi.digital.dao.entity.EquipmentEntity;
import com.carzapi.digital.dao.entity.PrivilegeEntity;
import com.carzapi.digital.model.dto.AnnouncementCriteria;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class AnnouncementSpecification implements Specification<AnnouncementEntity> {

    private AnnouncementCriteria criteria;

    @Override
    public Predicate toPredicate(Root<AnnouncementEntity> r, CriteriaQuery<?> q, CriteriaBuilder cb) {
        List<Predicate> predicates = new ArrayList<>();

        if (criteria.getBrandId() != null) {
            predicates.add(cb.equal(r.get("modelEntity").get("brandEntity").get("id"), (criteria.getBrandId())));
        }

        if (criteria.getModelId() != null) {
            predicates.add(cb.equal(r.get("modelEntity").get("id"), criteria.getModelId()));
        }

        if (criteria.getCityId() != null) {
            predicates.add(cb.equal(r.get("cityEntity").get("id"), criteria.getCityId()));
        }

        if (criteria.getPriceFrom() != null || criteria.getPriceTo() != null) {
            predicates.add(cb.between(
                    r.get("price"),
                    (criteria.getPriceFrom() != null) ? criteria.getPriceFrom() : 0D,
                    (criteria.getPriceTo() != null) ? criteria.getPriceTo() : Double.MAX_VALUE));
        }

        if (criteria.getYearFrom() != null || criteria.getYearTo() != null) {
            predicates.add(cb.between(
                    r.get("year"),
                    (criteria.getYearFrom() != null) ? criteria.getYearFrom() : 0,
                    (criteria.getYearTo() != null) ? criteria.getYearTo() : Integer.MAX_VALUE));
        }

        if (criteria.getMotorSizeFrom() != null || criteria.getMotorSizeTo() != null) {
            predicates.add(cb.between(
                    r.get("motorSize"),
                    (criteria.getMotorSizeFrom() != null) ? criteria.getMotorSizeFrom() : 0,
                    (criteria.getMotorSizeTo() != null) ? criteria.getMotorSizeTo() : Integer.MAX_VALUE));
        }

        if (criteria.getMotorPowerFrom() != null || criteria.getMotorPowerTo() != null) {
            predicates.add(cb.between(
                    r.get("motorPower"),
                    (criteria.getMotorPowerFrom() != null) ? criteria.getMotorPowerFrom() : 0,
                    (criteria.getMotorPowerTo() != null) ? criteria.getMotorPowerTo() : Integer.MAX_VALUE));
        }

        if (criteria.getDistanceUnitFrom() != null || criteria.getDistanceUnitTo() != null) {
            predicates.add(cb.between(
                    r.get("distanceUnit"),
                    (criteria.getDistanceUnitFrom() != null) ? criteria.getDistanceUnitFrom() : 0,
                    (criteria.getDistanceUnitTo() != null) ? criteria.getDistanceUnitTo() : Integer.MAX_VALUE));
        }

        if (criteria.getColourId() != null) {
            predicates.add(cb.equal(r.get("colourId").get("id"), criteria.getColourId()));
        }

        if (criteria.getFuel() != null) {
            predicates.add(cb.equal(r.get("fuel"), criteria.getFuel()));
        }

        if (criteria.getCcy() != null) {
            predicates.add(cb.equal(r.get("ccy"), criteria.getCcy()));
        }

        if (criteria.getGearBox() != null) {
            predicates.add(cb.equal(r.get("gearBox"), criteria.getGearBox()));
        }

        if (criteria.getConductorType() != null) {
            predicates.add(cb.equal(r.get("conductorType"), criteria.getConductorType()));
        }

        if (criteria.getDistanceType() != null) {
            predicates.add(cb.equal(r.get("distanceType"), criteria.getDistanceType()));
        }

        if (criteria.getOwnership() != null) {
            predicates.add(cb.equal(r.get("ownership"), criteria.getOwnership()));
        }

        if (criteria.getSeatCount() != null) {
            predicates.add(cb.equal(r.get("seatCount"), criteria.getSeatCount()));
        }

//        if (criteria.getPrivileges() != null) {
//            predicates.add(cb.isTrue(cb.function("jsonb_exists_any",
//                    Boolean.class,
//                    r.get("privileges"),
//                    cb.literal(criteria.getPrivileges().stream().map(Enum::name).toArray(String[]::new))))
//            );
//        }

        if (criteria.getPrivilegeIds() != null) {
            Join<AnnouncementEntity, AnnouncementPrivilegeEntity> joinA = r.join("announcementPrivilegeEntities");
            predicates.add(cb.greaterThanOrEqualTo(joinA.get("expiredAt"), cb.currentTimestamp()));
            Join<AnnouncementPrivilegeEntity, PrivilegeEntity> joinP = joinA.join("privilegeEntity");
            predicates.add(joinP.get("id").in(criteria.getPrivilegeIds()));
        }


        if (criteria.getConditionIds() != null) {
            Join<AnnouncementEntity, ConditionEntity> joint = r.join("conditionEntities");
            predicates.add(joint.get("id").in(criteria.getConditionIds()));
        }

        if (criteria.getEquipmentIds() != null) {
            Join<AnnouncementEntity, EquipmentEntity> joint = r.join("equipmentEntities");
            predicates.add(joint.get("id").in(criteria.getEquipmentIds()));
        }

        return cb.and(predicates.toArray(new Predicate[0]));
    }
}

