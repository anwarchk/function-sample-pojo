/*
 * Copyright 2013-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;

import java.util.function.Function;
import java.util.function.Supplier;

@SpringBootApplication
public class SampleApplication {

//    @Bean
//    public Function<Foo, Bar> uppercase() {
//        return value -> Bar.valueOf(value.uppercase());
//    }

    @Bean
    public Function<String, String> uppercase() {
        return value -> value.toUpperCase();
    }

    @Bean
    public Supplier<Flux<Foo>> words() {
        return () -> Flux.fromArray(new Foo[]{new Foo("foo"), new Foo("bar")}).log();
    }

    public static void main(String[] args) {
        SpringApplication.run(SampleApplication.class, args);
    }

}

class Foo {

    private String value;

    Foo() {
    }

    public String lowercase() {
        return value.toLowerCase();
    }

    public Foo(String value) {
        this.value = value;
    }

    public String uppercase() {
        return value.toUpperCase();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

class Bar {

    private String value;

    Bar() {
    }

    public static Bar valueOf(String value) {
        return new Bar(value);
    }

    Bar(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
