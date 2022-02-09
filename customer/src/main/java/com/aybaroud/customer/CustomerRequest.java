package com.aybaroud.customer;

/*
A record declaration contains :
getters, constructor, equals, hashCode, and toString methods are created automatically.
A record's fields are final because the class is immutable. No setters generated.
An immutable object is an object whose internal state remains constant after it has been entirely created.
 */
public record CustomerRequest(
        String firstName,
        String lastName,
        String email) {
}
