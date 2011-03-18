package com.summitbid.coach.nutrition

class MealPlanController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [mealPlanInstanceList: MealPlan.list(params), mealPlanInstanceTotal: MealPlan.count()]
    }

    def create = {
        def mealPlanInstance = new MealPlan()
        mealPlanInstance.properties = params
        return [mealPlanInstance: mealPlanInstance]
    }

    def save = {
        def mealPlanInstance = new MealPlan(params)
        if (mealPlanInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'mealPlan.label', default: 'MealPlan'), mealPlanInstance.id])}"
            redirect(action: "show", id: mealPlanInstance.id)
        }
        else {
            render(view: "create", model: [mealPlanInstance: mealPlanInstance])
        }
    }

    def show = {
        def mealPlanInstance = MealPlan.get(params.id)
        if (!mealPlanInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'mealPlan.label', default: 'MealPlan'), params.id])}"
            redirect(action: "list")
        }
        else {
            [mealPlanInstance: mealPlanInstance]
        }
    }

    def edit = {
        def mealPlanInstance = MealPlan.get(params.id)
        if (!mealPlanInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'mealPlan.label', default: 'MealPlan'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [mealPlanInstance: mealPlanInstance]
        }
    }

    def update = {
        def mealPlanInstance = MealPlan.get(params.id)
        if (mealPlanInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (mealPlanInstance.version > version) {
                    
                    mealPlanInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'mealPlan.label', default: 'MealPlan')] as Object[], "Another user has updated this MealPlan while you were editing")
                    render(view: "edit", model: [mealPlanInstance: mealPlanInstance])
                    return
                }
            }
            mealPlanInstance.properties = params
            if (!mealPlanInstance.hasErrors() && mealPlanInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'mealPlan.label', default: 'MealPlan'), mealPlanInstance.id])}"
                redirect(action: "show", id: mealPlanInstance.id)
            }
            else {
                render(view: "edit", model: [mealPlanInstance: mealPlanInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'mealPlan.label', default: 'MealPlan'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def mealPlanInstance = MealPlan.get(params.id)
        if (mealPlanInstance) {
            try {
                mealPlanInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'mealPlan.label', default: 'MealPlan'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'mealPlan.label', default: 'MealPlan'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'mealPlan.label', default: 'MealPlan'), params.id])}"
            redirect(action: "list")
        }
    }
}
