import React from 'react'
import {Box, Card,CardContent, CardMedia, CardActionArea, Typography } from "@material-ui/core"
import { Theme, createStyles, makeStyles } from "@material-ui/core/styles";
import { useNavigate } from "react-router-dom";

const useStyles = makeStyles((theme: Theme) =>
  createStyles({
    root: {
        display: "flex",
        flexWrap: "wrap",
        "& > *": {
            margin: theme.spacing(3),
        },
    },
  })
);

export default function ProductItem( {item} ) {
    const classes = useStyles();
    const navigate = useNavigate();
    console.log(item)
    console.log(item.imgPath)
    return (
        <Box className={classes.root} sx={{ width: '30%', height: '30%' }} >
            <Card key = {item.id}>
            <CardActionArea onClick={() => navigate("/singleproduct", {state: {item:item}})}>
                <CardContent>
                    {/* <CardMedia component="img" image={ bakery1 } /> */}
                    <CardMedia component="img" image={ item.imgPath } />
                    {/* <CardMedia className={classes.media} src={require('./image_folder/f_bakery/몬드베이커리_몬드_가족세트_63100.jpeg')} /> */}
                </CardContent>
                <CardContent>
                    <Typography variant="h5"> {item.name} </Typography>
                </CardContent>
            </CardActionArea>
            </Card>
        </Box>
    )
}
