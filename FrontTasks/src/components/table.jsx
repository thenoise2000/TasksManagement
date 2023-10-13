import React, { Component } from 'react';

export default class Table extends Component {
  toCssClasses(numbers) {
    const cols = numbers ? numbers.split(' ') : [];
    let classes = '';

    cols.forEach((col, index) => {
      if (col) {
        switch (index) {
          case 0:
            classes += `col-xs-${col}`;
            break;
          case 1:
            classes += ` col-sm-${col}`;
            break;
          case 2:
            classes += ` col-md-${col}`;
            break;
          case 3:
            classes += ` col-lg-${col}`;
            break;
          default:
            break;
        }
      }
    });

    return classes;
  }

  render() {
    const tableClasses = this.toCssClasses(this.props.cols || 12);

    return (
      <div className={tableClasses}>
        {this.props.children}
      </div>
    );
  }
}