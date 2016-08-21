###1.3.0:

- Interconnect _Tabbels_ using `inject(Tabbels... dependency)`

###1.2.0:

- Remove the need to cast Tabbels android to Tabbels core (use core directly)
- Add optional description string on methods for future documentation purposes
- Option to init _Tabbel_ from another _Tabbel_ as seed to use their methods transparently

###1.1.0:

- Functions without return (like in rxjava) -> Actions, use them with `aλ`
- Old `λ` renamed to `fλ` to refrect the usage of Function instead of Action usage
- Removed rxjava dependecy
- Adds helper methods `isAction(String methodName)` and `isFunction(String methodName)`
