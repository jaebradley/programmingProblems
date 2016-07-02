package problems.interfaces;

import java.util.List;
import java.util.Stack;

public interface AdjacentDuplicateCharactersRemover {
  String removeAdjacentDuplicateCharacters(final String candidate);

  List<Character> filterAdjacentDuplicateCharacters(final Stack<Character> characters);
}
