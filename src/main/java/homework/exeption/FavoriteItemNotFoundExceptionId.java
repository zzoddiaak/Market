package homework.exeption;

public class FavoriteItemNotFoundExceptionId extends RuntimeException {
    public FavoriteItemNotFoundExceptionId(Long id) {
      super(String.format("Favorite item %s not found", id));
    }
}
