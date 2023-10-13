import React from 'react'
import IconButton from '../components/Buttons'

export default props => {

    const renderRows = () => {
        const list = props.list || [];
        return list.map(task => (
            <tr key={task.id} className="text-center">
                <td className="text-left">{task.task}</td>
                <td className="text-center">{task.date_task}</td>
                <td>
                    {task.completed ? (
                        <IconButton style='default' icon='check-circle' onClick={() => props.handleMarkAsPending(task)}></IconButton>
                    ) : (
                        <IconButton style='default' icon='circle-thin' onClick={() => props.handleMarkAsDone(task)}></IconButton>
                    )}
                </td>                                    
                <td>
                    <IconButton style='danger' icon='eraser' onClick={() => props.handleRemove(task.id)}></IconButton>
                </td>
            </tr>
        ));
    };
    
    return (
        <table className='table table-striped'>
            <thead>
                <tr>
                    <th className='tableActions text-center'>Task</th>
                    <th className='text-center'>Date Task</th>
                    <th className='text-center'>Completed</th>                       
                    <th className='tableActions'>Delete</th>
                </tr>
            </thead>
            <tbody>
                {renderRows()}
            </tbody>
        </table>
    );
}