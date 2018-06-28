package com.fcu.gtml.edx.service;

import java.util.ArrayList;
import java.util.List;

public class CallKeyIdAPIServiceImpl extends CallAPIAdapter {

    @Override
    public List<String> listKeyIds() {
        List<String> list = new ArrayList<>();
        list.add("AAA");
        list.add("BBBB");
        list.add("CCC");
        return list;
    }
}
