import React from 'react'

export default function Avartar({image, isNew}) {
    return (
        <div>
            <img className='photo' src={image} />
            {isNew && <span className='new'>NEW</span>}
        </div>
    )
}
