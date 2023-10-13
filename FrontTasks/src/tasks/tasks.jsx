import React, {Component} from 'react'
import axios from 'axios'

import TaskForm from './taskForm'
import TaskList from './taskList'

const URL = 'http://localhost:8080/api/task'

export default class Tasks extends Component {
    constructor(props){
        super(props)
        this.state = {task: '', list: []}
        this.handleChange = this.handleChange.bind(this)
        this.handleAdd = this.handleAdd.bind(this)        
        this.handleClear = this.handleClear.bind(this)
        this.handleMarkAsDone = this.handleMarkAsDone.bind(this)
        this.handleMarkAsPending = this.handleMarkAsPending.bind(this)
        this.handleRemove = this.handleRemove.bind(this)
        this.refresh()
    }

    refresh(task = '') {
        debugger
        const filter = task ? `/search?task=${task}` : ''
        axios.get(`${URL}` + filter)
            .then(resp => this.setState({...this.state, task: '', list: resp.data.tasks}))
    }

    handleSearch() {
        this.refresh(this.state.task)
    }

    handleAdd() {
        const task = this.state.task;
        debugger
        if(task !== ''){
            axios.post(URL, { "task": task, "completed": false })
                .then(resp => this.refresh())
        }
    }

    handleChange(e) {
        this.setState({...this.state , task: e.target.value})
    }

    handleMarkAsDone(task) {
        axios.put(URL, {...task, completed: true})
            .then(resp => this.refresh())
    }

    handleMarkAsPending(task) {
        axios.put(URL, {...task, completed: false})
            .then(resp => this.refresh())
    }

    handleRemove(id) {
        axios.delete(`${URL}/${id}`)
            .then(resp => this.refresh())
    }

    handleClear() {
        this.refresh()
    }

    render(){
        return (
            <div>
                {/*<PageHeader name='Task'></PageHeader>*/}
                <TaskForm
                    task={this.state.task}
                    handleChange={this.handleChange}
                    handleAdd={this.handleAdd}                    
                    handleClear={this.handleClear} />
                <TaskList
                    list={this.state.list}
                    handleMarkAsDone={this.handleMarkAsDone}
                    handleMarkAsPending={this.handleMarkAsPending}
                    handleRemove={this.handleRemove} />
            </div>
        )
    }
}