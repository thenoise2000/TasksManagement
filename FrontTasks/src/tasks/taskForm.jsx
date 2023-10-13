import React from 'react';
import Grid from '../components/table';
import IconButton from '../components/Buttons';

const TaskForm = (props) => {
  const keyHandler = (e) => {
    if (e.key === 'Enter') {
      e.shiftKey ? props.handleSearch() : props.handleAdd();
    } else if (e.key === 'Escape') {
      props.handleClear();
    }
  };

  return (
    <div role='form' className='taskForm'>
      <Grid cols='12 3 2'>
        <IconButton style='warning' icon='refresh' onClick={props.handleClear} />
        <IconButton style='success' icon='tasks' onClick={props.handleAdd} />        
      </Grid>
      <Grid cols='12 9 10'>
        <input
          id='task'
          className='form-control'
          placeholder='New Task'
          onChange={props.handleChange}
          value={props.task}
          onKeyUp={keyHandler}
        />
      </Grid>      
    </div>
  );
};

export default TaskForm;