import React from 'react';

const Navbar = () => {
  return (
    <nav className='navbar navbar-inverse bg-inverse'>
      <div className='header'>
        <div className='navbar-header'>
          <a className='navbar-brand' href='#'>
            Management System Tasks
          </a>
        </div>
        <div id='navbar' className='navbar-collapse collapse'>
          <ul className="nav navbar-nav">
            <li><a href='#/tasks'>Tasks</a></li>
            <li><a href='#/'>Info</a></li>
          </ul>
        </div>
      </div>
    </nav>
  );
};

export default Navbar;