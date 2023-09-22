package org.example.mapper;

public interface BaseMapper<E, T, K> {

    E mapToEntity(T t);

    E mapToEntityFull(K k);

    K mapToDto(E e);
}
