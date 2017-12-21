package entities;

/**
 * Created by dsanchez on 12/5/17.
 */
public interface EntityGateway<Entity, Id> {
    Entity find(Id id);
}
