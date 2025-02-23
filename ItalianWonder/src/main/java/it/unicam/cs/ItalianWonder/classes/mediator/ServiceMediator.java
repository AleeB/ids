package it.unicam.cs.ItalianWonder.classes.mediator;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;
@Component
public interface ServiceMediator {
  List<?> get(Map<String, Object> data, Class<?> type);
  List<?> get(Class<?> type);
  void post(Object data);
  void update(Object data);
  void delete(Object ID, Class<?> type);
}
