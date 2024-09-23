package it.unicam.cs.ItalianWonder.classes;

import it.unicam.cs.ItalianWonder.classes.users.Turista;

public class BodyTemplate<E>{
  Turista user;
  E data;

  public Turista getUser() {
    return user;
  }

  public BodyTemplate<E> setUser(Turista user) {
    this.user = user;
    return this;
  }

  public E getData() {
    return data;
  }

  public BodyTemplate<E> setData(E data) {
    this.data = data;
    return this;
  }
}
