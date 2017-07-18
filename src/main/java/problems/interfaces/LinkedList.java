package problems.interfaces;

import problems.data.Node;

public interface LinkedList {
  Node getHead();
  int getElementsCount();
  void add(Object data);
  void addAtIndex(Object data, int index);
}
