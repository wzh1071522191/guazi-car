package com.jk.service;


import com.jk.model.Details;
import com.jk.util.PageUtil;
import com.jk.util.ParameUtil;

import java.util.List;

public interface CommService {
    PageUtil cha(ParameUtil params);

    PageUtil dai(ParameUtil param);

    PageUtil fa(ParameUtil param);

    PageUtil yi(ParameUtil param);

    PageUtil wan(ParameUtil param);

    PageUtil guan(ParameUtil param);

    PageUtil tui(ParameUtil param);

    PageUtil kuan(ParameUtil parame);


    List<Details> xiang(Integer id);
}
