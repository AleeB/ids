package it.unicam.cs.ItalianWonder.classes.mediator;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;
@Component
public interface ServiceMediator {
  List<Object> get(Map<String, Object> data);
  List<Object> get();
  void post(Object data);
  void update(Object data);
  void delete(Object ID);
}
