
package br.com.gabrieldeoliveira.awisr.api.models;

public interface OutputModel<E> {

    public OutputModel<E> fromEntity(E entity);
}
