package com.summitbid.coach.activity

class ExerciseController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [exerciseInstanceList: Exercise.list(params), exerciseInstanceTotal: Exercise.count()]
    }

    def create = {
        def exerciseInstance = new Exercise()
        exerciseInstance.properties = params
        return [exerciseInstance: exerciseInstance]
    }

    def save = {
        def exerciseInstance = new Exercise(params)
        if (exerciseInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'exercise.label', default: 'Exercise'), exerciseInstance.id])}"
            redirect(action: "show", id: exerciseInstance.id)
        }
        else {
            render(view: "create", model: [exerciseInstance: exerciseInstance])
        }
    }

    def show = {
        def exerciseInstance = Exercise.get(params.id)
        if (!exerciseInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'exercise.label', default: 'Exercise'), params.id])}"
            redirect(action: "list")
        }
        else {
            [exerciseInstance: exerciseInstance]
        }
    }

    def edit = {
        def exerciseInstance = Exercise.get(params.id)
        if (!exerciseInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'exercise.label', default: 'Exercise'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [exerciseInstance: exerciseInstance]
        }
    }

    def update = {
        def exerciseInstance = Exercise.get(params.id)
        if (exerciseInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (exerciseInstance.version > version) {
                    
                    exerciseInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'exercise.label', default: 'Exercise')] as Object[], "Another user has updated this Exercise while you were editing")
                    render(view: "edit", model: [exerciseInstance: exerciseInstance])
                    return
                }
            }
            exerciseInstance.properties = params
            if (!exerciseInstance.hasErrors() && exerciseInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'exercise.label', default: 'Exercise'), exerciseInstance.id])}"
                redirect(action: "show", id: exerciseInstance.id)
            }
            else {
                render(view: "edit", model: [exerciseInstance: exerciseInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'exercise.label', default: 'Exercise'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def exerciseInstance = Exercise.get(params.id)
        if (exerciseInstance) {
            try {
                exerciseInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'exercise.label', default: 'Exercise'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'exercise.label', default: 'Exercise'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'exercise.label', default: 'Exercise'), params.id])}"
            redirect(action: "list")
        }
    }
}
