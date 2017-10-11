package ch.grze.frogment.core.provider

class UnableToCreateFrogmentInstanceException(clazz: Class<*>) : RuntimeException(clazz.canonicalName)