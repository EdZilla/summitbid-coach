package com.summitbid.coach.nutrition

class NutritionInfoController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [nutritionInfoInstanceList: NutritionInfo.list(params), nutritionInfoInstanceTotal: NutritionInfo.count()]
    }

    def create = {
        def nutritionInfoInstance = new NutritionInfo()
        nutritionInfoInstance.properties = params
        return [nutritionInfoInstance: nutritionInfoInstance]
    }

    def save = {
        def nutritionInfoInstance = new NutritionInfo(params)
        if (nutritionInfoInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'nutritionInfo.label', default: 'NutritionInfo'), nutritionInfoInstance.id])}"
            redirect(action: "show", id: nutritionInfoInstance.id)
        }
        else {
            render(view: "create", model: [nutritionInfoInstance: nutritionInfoInstance])
        }
    }

    def show = {
        def nutritionInfoInstance = NutritionInfo.get(params.id)
        if (!nutritionInfoInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'nutritionInfo.label', default: 'NutritionInfo'), params.id])}"
            redirect(action: "list")
        }
        else {
            [nutritionInfoInstance: nutritionInfoInstance]
        }
    }

    def edit = {
        def nutritionInfoInstance = NutritionInfo.get(params.id)
        if (!nutritionInfoInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'nutritionInfo.label', default: 'NutritionInfo'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [nutritionInfoInstance: nutritionInfoInstance]
        }
    }

    def update = {
        def nutritionInfoInstance = NutritionInfo.get(params.id)
        if (nutritionInfoInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (nutritionInfoInstance.version > version) {
                    
                    nutritionInfoInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'nutritionInfo.label', default: 'NutritionInfo')] as Object[], "Another user has updated this NutritionInfo while you were editing")
                    render(view: "edit", model: [nutritionInfoInstance: nutritionInfoInstance])
                    return
                }
            }
            nutritionInfoInstance.properties = params
            if (!nutritionInfoInstance.hasErrors() && nutritionInfoInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'nutritionInfo.label', default: 'NutritionInfo'), nutritionInfoInstance.id])}"
                redirect(action: "show", id: nutritionInfoInstance.id)
            }
            else {
                render(view: "edit", model: [nutritionInfoInstance: nutritionInfoInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'nutritionInfo.label', default: 'NutritionInfo'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def nutritionInfoInstance = NutritionInfo.get(params.id)
        if (nutritionInfoInstance) {
            try {
                nutritionInfoInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'nutritionInfo.label', default: 'NutritionInfo'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'nutritionInfo.label', default: 'NutritionInfo'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'nutritionInfo.label', default: 'NutritionInfo'), params.id])}"
            redirect(action: "list")
        }
    }
}
