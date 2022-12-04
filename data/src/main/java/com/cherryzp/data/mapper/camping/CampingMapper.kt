package com.cherryzp.data.mapper.camping

import com.cherryzp.data.entitiy.camping.CampingEntity
import com.cherryzp.domain.dto.CampingDto
import com.cherryzp.domain.extends.default

fun CampingEntity.mapperToCamping(): CampingDto =
    CampingDto(
        contentId.default(),
        facltNm.default(),
        lineIntro.default(),
        intro.default(),
        allar.default(),
        insrncAt.default(),
        trsagntNo.default(),
        bizrno.default(),
        facltDivNm.default(),
        mangeDivNm.default(),
        mgcDiv.default(),
        manageSttus.default(),
        hvofBgnde.default(),
        hvofEnddle.default(),
        featureNm.default(),
        induty.default(),
        lctCl.default(),
        doNm.default(),
        sigunguNm.default(),
        zipcode.default(),
        addr1.default(),
        addr2.default(),
        mapX.default(),
        mapY.default(),
        direction.default(),
        tel.default(),
        homepage.default(),
        resveUrl.default(),
        resveCl.default(),
        manageNmpr.default(),
        gnrlSiteCo.default(),
        autoSiteCo.default(),
        glampSiteCo.default(),
        caravSiteCo.default(),
        indvdlCaravSiteCo.default(),
        sitedStnc.default(),
        siteMg1Width.default(),
        siteMg2Width.default(),
        siteMg3Width.default(),
        siteMg1Vrticl.default(),
        siteMg2Vrticl.default(),
        siteMg3Vrticl.default(),
        siteMg1Co.default(),
        siteMg2Co.default(),
        siteMg3Co.default(),
        siteBottomCl1.default(),
        siteBottomCl2.default(),
        siteBottomCl3.default(),
        siteBottomCl4.default(),
        siteBottomCl5.default(),
        tooltip.default(),
        glampInnerFclty.default(),
        caravInnerFclty.default(),
        prmisnDe.default(),
        operPdCl.default(),
        operDeCl.default(),
        trlerAcmpnyAt.default(),
        caravAcmpnyAt.default(),
        toiletCo.default(),
        swrmCo.default(),
        wtrplCo.default(),
        brazierCl.default(),
        sbrsCl.default(),
        sbrsEtc.default(),
        posblFcltyCl.default(),
        posblFcltyEtc.default(),
        clturEventAt.default(),
        clturEvent.default(),
        exprnProgrmAt.default(),
        exprnProgrm.default(),
        extshrCo.default(),
        frprvtWrppCo.default(),
        frprvtSandCo.default(),
        fireSensorCo.default(),
        themaEnvrnCl.default(),
        eqpmnLendCl.default(),
        animalCmgCl.default(),
        tourEraCl.default(),
        firstImageUrl.default(),
        createdtime.default(),
        modifiedtime.default()
    )