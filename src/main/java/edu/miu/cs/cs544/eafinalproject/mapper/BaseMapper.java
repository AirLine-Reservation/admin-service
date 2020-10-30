package edu.miu.cs.cs544.eafinalproject.mapper;

import ma.glasnost.orika.BoundMapperFacade;
import ma.glasnost.orika.MapperFactory;
import org.apache.commons.lang.SerializationUtils;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class BaseMapper<Source, Target> {

    private BoundMapperFacade<Source, Target> mapper;

    private Class<Source> sourceType;

    private Class<Target> targetType;

    /*public BaseMapper(MapperFactory mapperFactory, Class<Source> sourceType, Class<Target> targetType) {
        super();

        this.sourceType = sourceType;
        this.targetType = targetType;

        mapper = registerMapper(mapperFactory);
    }*/


    protected BoundMapperFacade<Source, Target> registerMapper(MapperFactory mapperFactory) {
        mapperFactory.classMap(sourceType, targetType)
                .byDefault() // copies all the fields that have the same name and ignores the rest
                .register();

        return mapperFactory.getMapperFacade(sourceType, targetType);
    }

    public boolean isUpdate(Source source, Target target) {
        if(null == source) {
            return false;
        }

        @SuppressWarnings("unchecked")
        Target clone = (Target) SerializationUtils.clone((Serializable) target);

        return mapper.map(source, clone).equals(target) ? false : true;
    }

    public Target map(Source source) {
        return mapper.map(source);
    }

    public Target map(Source source, Target target) {
        return mapper.map(source, target);
    }

}
