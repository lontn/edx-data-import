package com.fcu.gtml.edx.service;

import java.util.List;

public interface CallOutSiteAPIService {
    public List<String> listKeyIds();

    public List<Integer> listNumbers();

    public List<Integer> listRatings();
}
