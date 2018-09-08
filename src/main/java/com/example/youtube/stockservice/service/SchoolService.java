package com.example.youtube.stockservice.service;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import com.example.youtube.stockservice.controller.CustomerController;
import com.example.youtube.stockservice.controller.SchoolController;
import com.example.youtube.stockservice.model.School;
import com.example.youtube.stockservice.util.SchoolUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resources;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;

@Slf4j
@Service
public class SchoolService {

    public Resources<School> getAllSchool(){
        List<School> schoolList = Arrays.asList(SchoolUtil.schoolList);
        Iterator<School> schoolIterator = schoolList.iterator();

        while (schoolIterator.hasNext()){
            School school = schoolIterator.next();

            school.removeLinks();

            school.add( linkTo(SchoolController.class).slash(school.getSchoolId()).withRel("detail") );
        }

        Link link = linkTo(SchoolController.class).withSelfRel();

        Resources<School> schoolResources = new Resources<School>(schoolList,link);

        return schoolResources;
    }

    @Async
    public Future<String> asyncTask(){
        log.info("asyncTask run" + Thread.currentThread().getName());

        try {
            Thread.sleep(5000);
            return new AsyncResult<String>("Hello World");
        }catch (Exception e){
            log.error(String.valueOf(e));
        }

        log.info("asyncTask işlemini bitirdi");
        return null;
    }

}
