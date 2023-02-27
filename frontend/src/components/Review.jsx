import React from 'react'
import { Card, CardHeader, CardContent, CardMedia, Typography } from "@material-ui/core"

function Review() {
    const firstname = "jess"
    const lastname = "kim"
    const stars = 3
    const comment = "good"
    const timestamp = "3 min ago"
  return (
    <Card>
      <CardContent>
        <CardHeader tag="h1">Reviews Page</CardHeader>
        <div className="reviews-top">
          <div className="user-details">
            <CardMedia
              component="img"
              image={"https://images.pexels.com/photos/7129713/pexels-photo-7129713.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"}
            />
            <Typography className="mb-2 text-muted" tag="h6">
              {firstname} {lastname || "John Doe"}
            </Typography>
            {[...Array(stars || 5)].map((star) => {
              return <Typography tag="h5">⭐ </Typography>;
            })}
          </div>
          <div className="reviews-body">
            <Typography>
              {comment ||
                "Lorem ipsum dolor sit amet consectetur adipisicing elit. Aut reiciendis delectus dignissimos, nisi pariatur fuga officiis itaque fugiat! Quibusdam accusantium quae beatae vel.Quas possimus reprehenderit sequi quia nesciunt sunt!"}
                </Typography>
          </div>
          <Typography>
            <small className="text-muted text-bold">
              {timestamp || "3 mins ago"}
            </small>
          </Typography>
        </div>
      </CardContent>
    </Card>
  );
}

export default Review
