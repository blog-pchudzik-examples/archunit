package com.pchudzik.blog.example.archunit.api.impl;

import com.pchudzik.blog.example.archunit.api.Api;
import com.pchudzik.blog.example.archunit.api.SomeCommand;
import com.pchudzik.blog.example.archunit.api.internal.InternalApi;
import com.pchudzik.blog.example.archunit.api.internal.OtherCommand;

public class ApiImpl implements Api, InternalApi {
    @Override
    public void doWork(SomeCommand command) {

    }

    @Override
    public void doMoreWork(OtherCommand command) {

    }

    @Override
    public void doInternalWork(OtherCommand cmd) {

    }
}
