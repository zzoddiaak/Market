package homework.repository;

import homework.entity.Entity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public abstract class AbstractRepository<T extends Entity> {
    private final List<T> objects = new ArrayList<>();
    private Long idCounter = 1L;

    public T findById(Long id) {
        return objects.stream()
                .filter(obj -> id.equals(obj.getId()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Object with id " + id + " not found"));
    }

    public List<T> findAll() {
        return new ArrayList<>(objects);
    }

    public void save(T object) {
        if (object.getId() == null || !objects.contains(object)) {
            if (object.getId() == null) {
                object.setId(idCounter++);
            }
            objects.add(object);
        } else {
            int index = objects.indexOf(object);
            objects.set(index, object);
        }
    }

    public void update(Long id, T updatedObject) {
        T existingObject = findById(id);
        objects.remove(existingObject);
        updatedObject.setId(id);
        objects.add(updatedObject);
    }

    public void deleteById(Long uuid) {
        objects.removeIf(obj -> uuid.equals(obj.getId()));
    }
}
