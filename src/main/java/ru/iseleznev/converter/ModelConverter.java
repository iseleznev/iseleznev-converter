package ru.iseleznev.converter;

public interface ModelConverter<Source, Target> {

    Target convert(Source source);
}
