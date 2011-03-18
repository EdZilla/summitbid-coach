package com.summitbid.coach.nutrition

class FoodController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [foodInstanceList: Food.list(params), foodInstanceTotal: Food.count()]
    }

    def create = {
        def foodInstance = new Food()
        foodInstance.properties = params
        return [foodInstance: foodInstance]
    }

    def save = {
        def foodInstance = new Food(params)
        if (foodInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'food.label', default: 'Food'), foodInstance.id])}"
            redirect(action: "show", id: foodInstance.id)
        }
        else {
            render(view: "create", model: [foodInstance: foodInstance])
        }
    }

    def show = {
        def foodInstance = Food.get(params.id)
        if (!foodInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'food.label', default: 'Food'), params.id])}"
            redirect(action: "list")
        }
        else {
            [foodInstance: foodInstance]
        }
    }

    def edit = {
        def foodInstance = Food.get(params.id)
        if (!foodInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'food.label', default: 'Food'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [foodInstance: foodInstance]
        }
    }

    def update = {
        def foodInstance = Food.get(params.id)
        if (foodInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (foodInstance.version > version) {
                    
                    foodInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'food.label', default: 'Food')] as Object[], "Another user has updated this Food while you were editing")
                    render(view: "edit", model: [foodInstance: foodInstance])
                    return
                }
            }
            foodInstance.properties = params
            if (!foodInstance.hasErrors() && foodInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'food.label', default: 'Food'), foodInstance.id])}"
                redirect(action: "show", id: foodInstance.id)
            }
            else {
                render(view: "edit", model: [foodInstance: foodInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'food.label', default: 'Food'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def foodInstance = Food.get(params.id)
        if (foodInstance) {
            try {
                foodInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'food.label', default: 'Food'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'food.label', default: 'Food'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'food.label', default: 'Food'), params.id])}"
            redirect(action: "list")
        }
    }
}
