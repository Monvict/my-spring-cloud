package com.lotus.service.impl;

import com.lotus.service.IUserService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Tony
 * 2018-06-22 10:39
 **/
@Slf4j
public class UserServiceImpl implements IUserService {

    @Override
    public void register() {
        log.info("Register successfully.");
    }
}
