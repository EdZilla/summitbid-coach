package com.summitbid.coach

/**
 
 */
class Property extends BaseDomain {
  String type
  SortedSet types
  SortedSet propertyValues
  SortedSet propertyMetadata
  Boolean isDefault = false
  
  /*
   * 
   */
  static hasMany = [ entities            : BaseDomain,
                     propertyValues   : PropertyValue ]
  

  static mappedBy = [propertyValues:'dynaProperty']

  static belongsTo = [ BaseDomain ]
  static possibleTypes = [ "Text", "Number", "List", "Date" ]
  static transients = [ possibleTypes ]

  static constraints = {
    name(nullable: false, blank: false)
    types(nullable:true)
    isDefault(nullable:true, default:true)
  }

  String getValue(BaseDomain entity) {
    getPropertyValue(entity)?.value
  }

  PropertyValue getPropertyValue(BaseDomain entity) {
    PropertyValue returnValue
    propertyValues.each { propertyValue ->
      if(propertyValue.entity == entity) {
        returnValue = propertyValue
      }
    }

    returnValue
  }
}
