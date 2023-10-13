import React from 'react'
import { Router, Route, Redirect, hashHistory } from 'react-router'

import Tasks from '../tasks/tasks'

export default props => (
    <Router history={hashHistory}>
        <Route path='/tasks' component={Tasks} />        
        <Redirect from='*' to='/tasks' />
    </Router>
)