import 'modules/bootstrap/dist/css/bootstrap.min.css'
import 'modules/font-awesome/css/font-awesome.min.css'
import '../components/components.css'

import React from 'react'
import Routes from './routes'
import Header from '../components/header'

export default props => (
    <div className='body'>
      <Header/>
      <Routes/>

    </div>
)