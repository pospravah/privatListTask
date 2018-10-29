import React from 'react';
import TasksTable from './tasks_table_component';

// const React = require('react');
// const TasksTable = require('tasks_table_component');

class ReadTasksComponent extends React.Component {

    constructor(props) {
        super(props);
        this.state = { tasks: [] };
        this.prom.then((resp) => {
            this.setState({tasks : resp})
        })
    }

    componentDidMount() {

        const options = {
            method: 'GET',
            uri: 'http://localhost:8080/api/tasklist',
            json: true
        }
        request(options)
            .then(function (response) {
                // Запрос был успешным, используйте объект ответа как хотите
                this.setState({
                    tasks: response.records
                });
                console.log("------componentDidMount----------" + response)
            })
            .catch(function (err) {
                // Произошло что-то плохое, обработка ошибки
                console.log("------componentDidMount----------" + err)
            })

    }

    componentWillUnmount(){
        this.serverRequest.abort();
    }

    render(){

        let filteredTasks = this.state.tasks;
        // $('.page-header h1').text('Read Tasks');

        return (
            <div className='overflow-hidden'>
                {/*<TopActionsComponent changeAppMode={this.props.changeAppMode} />*/}

                <TasksTable
                    products={filteredTasks}
                    changeAppMode={this.props.changeAppMode} />
            </div>
        );
    }
}

export default ReadTasksComponent;