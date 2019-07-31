package com.ciandt.investment.dataprovider;

import com.ciandt.investment.core.domain.InformeDiario;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class InformeDiarioGatewayTest {


    @Test
    public void sanity() {

        InformeDiarioGateway informeDiarioGateway = new InformeDiarioGateway();
        List<InformeDiario> informeDiarios = informeDiarioGateway.getAll();

        assertEquals(325850, informeDiarios.size());

    }


}