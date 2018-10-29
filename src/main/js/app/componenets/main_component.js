import React from 'react';
import ReadTasksComponent from './read_tasks_component';

// 'use strict';
// const React = require('react');
// const ReadTasksComponent = require('./read_tasks_component');

class MainApp extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            currentMode: 'read',
            taskId: null
        };
    }

    changeAppMode(newMode, taskId){
        this.setState({currentMode: newMode});
        if(taskId !== undefined){
            this.setState({taskId: taskId});
        }
        this.openPopup();
    }

    render(){
        let modeComponent =
            <ReadTasksComponent
                changeAppMode={this.changeAppMode} />;

        switch(this.state.currentMode){
            case 'read':
                break;
            case 'readOne':
                modeComponent = <ReadOneTaskComponent taskId={this.state.taskId} changeAppMode={this.changeAppMode}/>;
                break;
            case 'create':
                modeComponent = <CreateTaskComponent changeAppMode={this.changeAppMode}/>;
                break;
            case 'update':
                modeComponent = <UpdateTaskComponent taskId={this.state.taskId} changeAppMode={this.changeAppMode}/>;
                break;
            case 'delete':
                modeComponent = <DeleteTaskComponent taskId={this.state.taskId} changeAppMode={this.changeAppMode}/>;
                break;
            default:
                break;
        }

        return modeComponent;
    }
}

export default MainApp