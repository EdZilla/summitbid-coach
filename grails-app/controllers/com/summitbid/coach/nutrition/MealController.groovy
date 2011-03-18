package com.summitbid.coach.nutrition

class MealController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [mealInstanceList: Meal.list(params), mealInstanceTotal: Meal.count()]
    }

    def create = {
        def mealInstance = new Meal()
        mealInstance.properties = params
        return [mealInstance: mealInstance]
    }

    def save = {
        def mealInstance = new Meal(params)
        if (mealInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'meal.label', default: 'Meal'), mealInstance.id])}"
            redirect(action: "show", id: mealInstance.id)
        }
        else {
            render(view: "create", model: [mealInstance: mealInstance])
        }
    }

    def show = {
        def mealInstance = Meal.get(params.id)
        if (!mealInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'meal.label', default: 'Meal'), params.id])}"
            redirect(action: "list")
        }
        else {
            [mealInstance: mealInstance]
        }
    }

    def edit = {
        def mealInstance = Meal.get(params.id)
        if (!mealInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'meal.label', default: 'Meal'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [mealInstance: mealInstance]
        }
    }

    def update = {
        def mealInstance = Meal.get(params.id)
        if (mealInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (mealInstance.version > version) {
                    
                    mealInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'meal.label', default: 'Meal')] as Object[], "Another user has updated this Meal while you were editing")
                    render(view: "edit", model: [mealInstance: mealInstance])
                    return
                }
            }
            mealInstance.properties = params
            if (!mealInstance.hasErrors() && mealInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'meal.label', default: 'Meal'), mealInstance.id])}"
                redirect(action: "show", id: mealInstance.id)
            }
            else {
                render(view: "edit", model: [mealInstance: mealInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'meal.label', default: 'Meal'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def mealInstance = Meal.get(params.id)
        if (mealInstance) {
            try {
                mealInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'meal.label', default: 'Meal'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'meal.label', default: 'Meal'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'meal.label', default: 'Meal'), params.id])}"
            redirect(action: "list")
        }
    }
}
