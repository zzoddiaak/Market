package homework.exeption;

public class FavoriteItemNotFoundExceptionId extends RuntimeException {
    private static final String message = "Favorite item %s not found";
    public FavoriteItemNotFoundExceptionId(Long id) {
      super(String.format(message, id));
    }
}
