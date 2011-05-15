package com.summitbid.coach


/**
 
  */
class PropertyValue extends BaseDomain {
  Property dynaProperty
  BaseDomain entity
  String value
                   
  static belongsTo = [ dynaProperty:Property,  entity:BaseDomain ]

  static constraints = {
    value(size:1..80, nullable:true)
	entity(nullable: true, blank: true)
  }

  String toString() {
    value
  }
  
  /*int compareTo(obj) {
    def thisId = 0
    def objId  = 0

    if(this.property != null && obj.property != null) {
      thisId = this.property.id == null ? 0 : this.property.id
      objId = obj.property.id == null ? 0 : obj.property.id
    }
    else {
      thisId = this.id == null ? 0 : this.id
      objId = obj.id == null ? 0 : obj.id
    }

    thisId - objId
  }*/
}
