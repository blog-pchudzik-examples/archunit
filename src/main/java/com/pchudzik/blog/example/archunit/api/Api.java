package com.pchudzik.blog.example.archunit.api;

import com.pchudzik.blog.example.archunit.api.internal.OtherCommand;

public interface Api {
    void doWork(SomeCommand command);

    void doMoreWork(OtherCommand command);

}
